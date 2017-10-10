package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by quentin on 10-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchStats {

    private int seasonId;
    private int queueId;
    private long gameId;
    private List<ParticipantIdentity> participantIdentities;
    private String gameVersion;
    private String platformId;
    private String gameMode;
    private int mapId;
    private String gameType;
    private List<Team> teams;
    private List<Participant> participants;
    private long gameDuration;
    private long gameCreation;
}
