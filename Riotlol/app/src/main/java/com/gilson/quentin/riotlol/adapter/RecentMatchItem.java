package com.gilson.quentin.riotlol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gilson.quentin.riotlol.R;
import com.gilson.quentin.riotlol.model.MatchStats;
import com.gilson.quentin.riotlol.model.Participant;
import com.gilson.quentin.riotlol.model.ParticipantIdentity;
import com.gilson.quentin.riotlol.realm.ChampionRealmObject;
import com.gilson.quentin.riotlol.realm.ItemRealmObject;
import com.gilson.quentin.riotlol.realm.RealmManager;
import com.gilson.quentin.riotlol.realm.SummonerSpellRealmObject;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by quentin on 10-10-17.
 */

public class RecentMatchItem extends AbstractItem<RecentMatchItem,RecentMatchItem.ViewHolder>{

    private MatchStats matchStats;
    private int id;
    private Context context;

    public RecentMatchItem(MatchStats matchStats, int id, Context context) {
        this.matchStats = matchStats;
        this.id = id;
        this.context = context;
    }

    @Override
    public int getType() {
        return R.id.textview_win;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recent_match_row;
    }

    @Override
    public void bindView(ViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);
        holder.refresh(matchStats,id,context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Context context;

        @BindView(R.id.textview_kda)
        TextView kda;
        @BindView(R.id.textview_win)
        TextView win;
        @BindView(R.id.textview_gametype)
        TextView gametype;
        @BindView(R.id.textview_gamecreation)
        TextView gamecreation;
        @BindView(R.id.textview_gameduration)
        TextView gameduration;
        @BindView(R.id.textview_champion_name)
        TextView championName;
        @BindView(R.id.imageview_champion)
        ImageView imageChampion;
        @BindView(R.id.imageview_summoner_spell1)
        ImageView summonerSpell1;
        @BindView(R.id.imageview_summoner_spell2)
        ImageView summonerSpell2;
        @BindView(R.id.layout_cardview)
        RelativeLayout layoutCardview;
        @BindView(R.id.textview_gold)
        TextView gold;
        @BindView(R.id.textview_level)
        TextView level;
        @BindView(R.id.imageview_item0)
        ImageView item0;
        @BindView(R.id.imageview_item1)
        ImageView item1;
        @BindView(R.id.imageview_item2)
        ImageView item2;
        @BindView(R.id.imageview_item3)
        ImageView item3;
        @BindView(R.id.imageview_item4)
        ImageView item4;
        @BindView(R.id.imageview_item5)
        ImageView item5;
        @BindView(R.id.imageview_item6)
        ImageView item6;
        @BindView(R.id.textview_cs)
        TextView cs;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void refresh(MatchStats matchStats, int id, Context context) {
            //pas besoin de refresh quand on scroll
            this.context = context;
            int partId = 0;

            gametype.setText(matchStats.getGameMode());
            gamecreation.setText(getCreation(matchStats.getGameCreation()));
            gameduration.setText(getDuration(matchStats.getGameDuration()));

            for(ParticipantIdentity participantIdentity : matchStats.getParticipantIdentities()){
                if(participantIdentity.getPlayer().getAccountId() == id){
                    partId = participantIdentity.getParticipantId();
                }
            }

            for(Participant participant : matchStats.getParticipants()){
                if(participant.getParticipantId() == partId){
                    int kill = participant.getStats().getKills();
                    int assist = participant.getStats().getAssists();
                    int death = participant.getStats().getDeaths();
                    boolean won = participant.getStats().isWin();
                    int minions = participant.getStats().getNeutralMinionsKilled()+participant.getStats().getTotalMinionsKilled();

                    gold.setText("gold : "+participant.getStats().getGoldEarned());
                    level.setText("level : "+participant.getStats().getChampLevel());
                    cs.setText("cs : "+minions);

                    ChampionRealmObject champ = RealmManager.getRealmManager().getChampion(participant.getChampionId());
                    //championName.setText(champ.getName());
                    Glide.with(context).load("http://ddragon.leagueoflegends.com/cdn/7.5.2/img/champion/"+champ.getImage().getFull()).into(imageChampion);

                    SummonerSpellRealmObject spell = RealmManager.getRealmManager().getSummonerSpell(participant.getSpell1Id());
                    Glide.with(context).load("http://ddragon.leagueoflegends.com/cdn/7.5.2/img/spell/"+spell.getImage().getFull()).into(summonerSpell1);
                    spell = RealmManager.getRealmManager().getSummonerSpell(participant.getSpell2Id());
                    Glide.with(context).load("http://ddragon.leagueoflegends.com/cdn/7.5.2/img/spell/"+spell.getImage().getFull()).into(summonerSpell2);

                    ItemRealmObject item = RealmManager.getRealmManager().getItem(participant.getStats().getItem0());
                    updateItemImage(item,item0);
                    item = RealmManager.getRealmManager().getItem(participant.getStats().getItem1());
                    updateItemImage(item,item1);
                    item = RealmManager.getRealmManager().getItem(participant.getStats().getItem2());
                    updateItemImage(item,item2);
                    item = RealmManager.getRealmManager().getItem(participant.getStats().getItem3());
                    updateItemImage(item,item3);
                    item = RealmManager.getRealmManager().getItem(participant.getStats().getItem4());
                    updateItemImage(item,item4);
                    item = RealmManager.getRealmManager().getItem(participant.getStats().getItem5());
                    updateItemImage(item,item5);
                    item = RealmManager.getRealmManager().getItem(participant.getStats().getItem6());
                    updateItemImage(item,item6);

                    kda.setText(kill+"/"+death+"/"+assist);
                    if(won){
                        layoutCardview.setBackgroundColor(context.getResources().getColor(R.color.winGreen));
                    }else{
                        layoutCardview.setBackgroundColor(context.getResources().getColor(R.color.loseRed));
                    }
                }
            }
        }

        public void updateItemImage(ItemRealmObject item, ImageView imageView) {
            if(item!=null){
                Glide.with(context).load("http://ddragon.leagueoflegends.com/cdn/7.5.2/img/item/"+item.getImage().getFull()).into(imageView);
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }
        }

        public String getDuration(long duration){
            long minute = duration/60;
            long sec = duration%60;
            return ""+minute+"m"+sec+"s";
        }

        public String getCreation(long creation) {
            Date now = new Date();
            long timeAgo = now.getTime() - creation;
            long sec = (timeAgo/1000)%60;
            long min = (timeAgo/1000)/60;
            long hour = min/60;
            min = min%60;
            long day = hour/24;
            hour = hour%24;
            long month = day/30;
            month = month%30;

            if(month>0){
                return month+" month ago";
            } else if(day>0) {
                return day+" days ago";
            } else if(hour>0){
                return hour+" hours ago";
            } else if(min>0){
                return min+" min ago";
            } else if(sec>0) {
                return sec+" sec ago";
            } else {
                return "now";
            }
        }
    }

}
