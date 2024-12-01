package use_case.transcript;

import entity.Transcript;

/**
 * The interface of the DAI for the Transcription Use Case
 */
public interface TranscriptDataUserAccessInterface {

    /**
     * Retrieve the transcription from YouTube URL.
     * @param youtubeUrl the URL of the YouTube video
     * @return the transcript as a Transcript object
     */
    Transcript getTranscript(String youtubeUrl);
}

