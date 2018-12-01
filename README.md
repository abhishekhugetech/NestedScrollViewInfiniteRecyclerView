# Infinite Recycler View inside Nested Scroll View 
Implementing Recycler View's Infinite scroll inside of Nested Scroll View in Android

To Implement this we add a global scroll listener to our nested scroll view by first getting the ViewTreeObserver
by using getViewTreeObserver() method on the nested scroll view object. Then we add a scroll change listener using 
addOnScrollChangedListener() method.

<strong> The Main Code </strong> :

<br>

        nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged()
            {
                View view = (View)nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);

                int diff = (view.getBottom() - (nestedScrollView.getHeight() + nestedScrollView
                        .getScrollY()));

                if (diff == 0) {
                    // your pagination code
                    progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadMoreData();
                        }
                    },500);
                }
            }
        });
        
       
 <br>
 <img src="">
