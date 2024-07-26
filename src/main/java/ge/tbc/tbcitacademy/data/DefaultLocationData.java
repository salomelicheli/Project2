package ge.tbc.tbcitacademy.data;

public class DefaultLocationData {
    private String defaultLocation;

    public String getDefaultLocationAfterDeletingFilter() {
        return defaultLocationAfterFilter;
    }
    public void setDefaultLocationAfterDeletingFilter(String defaultLocationAfterFilter) {
        this.defaultLocationAfterFilter = defaultLocationAfterFilter;
    }

    private String defaultLocationAfterFilter;

    public String getDefaultLocation() {
        return defaultLocation;
    }
    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }
}
