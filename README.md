# ReviewApp
This app allows users to browse all of the reviews if they wish, also there is a mock method for posting new review.

# UI
Simple UI consists of recycler view that display the users reviews with some relative data to each review (rating, title, message, date  ...etc.)
Also there is a details activity for displaying each review.

# Utils
There is network utile for checking the network availability 
Also there is shared preferences manager for setting the data and getting it the device is offline

# Mock [Posting New Review]
I assumed that the required fields are title, rating value and message.
Then I made handler for mimicking the request that would take 2 seconds and the response returned with an object of 'Datum'
that should be added to the reviews list

In real case I think there is two other fields should be included in the structure the POST payload, those fields are
userId: unique identifier of each user
place or tourId: unique identifier that indicates specific place


```Java
 /**
     * posting new review
     * @param rateValue
     * @param message
     * @param title
     * @param networkCallBack
     */
    public void postNewReview(final float rateValue, final String message,
                              final String title,
                              final  NetworkCallBack<Datum> networkCallBack)
    {
       final Handler handler = new Handler(Looper.getMainLooper());
       new Thread(new Runnable()
       {
           @Override
           public void run()
           {
              try{ Thread.sleep(2000);}catch (Exception e){/**/}
               handler.post(new Runnable()
               {
                   @Override
                   public void run()
                   {
                       Datum postingResponse = new Datum();
                       postingResponse.setTitle(title);
                       postingResponse.setTitle(message);
                       postingResponse.setRating(String.valueOf(rateValue));
                       networkCallBack.onSuccess(new Datum());
                   }
               });
           }
       }).start();
    }
...
