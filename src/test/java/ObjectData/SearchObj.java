package ObjectData;

import java.util.HashMap;

public class SearchObj {

    private String searchBoxInput;

    private String product1Name;

    private String product2Name;

    private String product3Name;

    private String url;

    private String searchAlertValue;
    private String invalidSearch;
    private String noProductFoundMessage;

    public String getNoProductFoundMessage() {
        return noProductFoundMessage;
    }

    public void setNoProductFoundMessage(String noProductFoundMessage) {
        this.noProductFoundMessage = noProductFoundMessage;
    }

    public String getInvalidSearch() {
        return invalidSearch;
    }

    public void setInvalidSearch(String invalidSearch) {
        this.invalidSearch = invalidSearch;
    }

    public String getSearchAlertValue() {
        return searchAlertValue;
    }

    public void setSearchAlertValue(String searchAlertValue) {
        this.searchAlertValue = searchAlertValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProduct3Name() {
        return product3Name;
    }

    public void setProduct3Name(String product3Name) {
        this.product3Name = product3Name;
    }

    public String getProduct2Name() {
        return product2Name;
    }

    public void setProduct2Name(String product2Name) {
        this.product2Name = product2Name;
    }

    public String getProduct1Name() {
        return product1Name;
    }

    public void setProduct1Name(String product1Name) {
        this.product1Name = product1Name;
    }

    public String getSearchBoxInput() {
        return searchBoxInput;
    }

    public void setSearchBoxInput(String searchBoxInput) {
        this.searchBoxInput = searchBoxInput;
    }

    public SearchObj(HashMap<String,String> testData){
        populateObject(testData);
    }

    private void populateObject(HashMap<String,String> testData){
        for (String Key: testData.keySet()){
            switch (Key){
                case "searchBoxInput":
                    setSearchBoxInput(testData.get(Key));
                    break;
                case "product1Name":
                    setProduct1Name(testData.get(Key));
                    break;
                case "product2Name":
                    setProduct2Name(testData.get(Key));
                    break;
                case "product3Name":
                    setProduct3Name(testData.get(Key));
                    break;
                case "url":
                    setUrl(testData.get(Key));
                    break;
                case "searchAlertValue":
                    setSearchAlertValue(testData.get(Key));
                    break;
                case "invalidSearch":
                    setInvalidSearch(testData.get(Key));
                    break;
                case "noProductFoundMessage":
                    setNoProductFoundMessage(testData.get(Key));
                    break;
            }
        }
    }
}
