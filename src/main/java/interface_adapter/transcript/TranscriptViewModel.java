package interface_adapter.transcript;

import java.util.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * The View Model for the Transcript View
 */
public class TranscriptViewModel {
    public static final String TRANSCRIPT_PROPERTY = "transcript";
    private String transcript;
    private final PropertyChangeSupport support;

    public TranscriptViewModel() {
        this.support = new PropertyChangeSupport(this);
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        String oldTranscript = this.transcript;
        this.transcript = transcript;
        support.firePropertyChange("transcript", oldTranscript, transcript);
    }

    /**
     * Adds a PropertyChangeListener to this ViewModel.
     * @param listener The PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * Removes a PropertyChangeListener to this ViewModel.
     * @param listener The PropertyChangeListener to be removed.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
