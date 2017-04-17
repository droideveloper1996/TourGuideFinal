package tourguide.project.com.tourguide;

/**
 * Created by Abhishek on 16/04/2017.
 */

class City {
    private String mPlace;
    private String mDescription;
    private String mRestaurants;
    private String mAttraction;
    private String mEvent;
    private String mType;

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public int getmImageResouceId() {
        return mImageResouceId;
    }

    public void setmImageResouceId(int mImageResouceId) {
        this.mImageResouceId = mImageResouceId;
    }

    private int mImageResouceId;
    private int mIconResourceId;
    public static final int mIMAGE_ID_CONSTANT=-1;

    public City(String mPlace, String mType,String mDescription, String mRestaurants, String mAttraction, String mEvent,int mIconResourceId) {
        this.mPlace = mPlace;
        this.mDescription = mDescription;
        this.mRestaurants = mRestaurants;
        this.mAttraction = mAttraction;
        this.mEvent = mEvent;
        this.mType=mType;
        mImageResouceId=mIMAGE_ID_CONSTANT;
        this.mIconResourceId=mIconResourceId;
    }

    public int getmIconResourceId() {
        return mIconResourceId;
    }

    public void setmIconResourceId(int mIconResourceId) {
        this.mIconResourceId = mIconResourceId;
    }

    public City(String mPlace, String mType, String mDescription, String mRestaurants, String mAttraction, String mEvent, int mImageResouceId, int mIconResourceId) {
        this.mPlace = mPlace;
        this.mDescription = mDescription;
        this.mRestaurants = mRestaurants;
        this.mAttraction = mAttraction;
        this.mEvent = mEvent;
        this.mType=mType;

        this.mIconResourceId=mIconResourceId;
        this.mImageResouceId=mImageResouceId;
    }
    public String getmPlace() {
        return mPlace;
    }

    public void setmPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmRestaurants() {
        return mRestaurants;
    }

    public void setmRestaurants(String mRestaurants) {
        this.mRestaurants = mRestaurants;
    }

    public String getmAttraction() {
        return mAttraction;
    }

    public void setmAttraction(String mAttraction) {
        this.mAttraction = mAttraction;
    }

    public String getmEvent() {
        return mEvent;
    }

    public void setmEvent(String mEvent) {
        this.mEvent = mEvent;
    }


}
