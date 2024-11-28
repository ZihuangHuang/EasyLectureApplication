package interface_adapter;

import java.util.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * The View Model for the Summary View.
 */
public class SummaryViewModel {
    private String summary;
    private final PropertyChangeSupport support;
    private List<String> topics;

    public SummaryViewModel() {
        this.support = new PropertyChangeSupport(this);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        String oldSummary = this.summary;
        this.summary = summary;
        support.firePropertyChange("summary", oldSummary, summary);
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        List<String> oldTopics = this.topics;
        this.topics = topics;
        support.firePropertyChange("topics", oldTopics, topics);
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
