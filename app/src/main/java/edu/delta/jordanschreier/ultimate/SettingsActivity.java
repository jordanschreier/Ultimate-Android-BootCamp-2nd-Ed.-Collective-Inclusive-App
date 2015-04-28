// SettingsActivity.java
// Activity to display SettingsFragment on a phone
package edu.delta.jordanschreier.ultimate;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class SettingsActivity extends ActionBarActivity
{
   // use FragmentManager to display SettingsFragment
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_settings);

       getSupportActionBar().setDisplayShowHomeEnabled(true);
       getSupportActionBar().setIcon(R.drawable.flag_icon);
   }
} // end class SettingsActivity



/*************************************************************************
* (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/