package com.neopixl.noteapp.data

import com.neopixl.noteapp.domain.models.Step

object DataStore {
    val stepSamples = listOf(
        Step(
            1,
            "Prepa",
            "Create a court (e.g. 12m x 6m); divide it by a net or no-go zone into 2 ‘yards’"
        ),
        Step(2, "Positions", "Play in teams; each team stays in their own yard"),
        Step(3, "Objects", "Scatter throwing objects –‘rubbish’ – across each yard"),
        Step(
            4,
            "Rules",
            "Teams gather rubbish from their own yard and throw it into the opposing team’s yard; only collect and throw one piece of rubbish at a time"
        ),
    )
}