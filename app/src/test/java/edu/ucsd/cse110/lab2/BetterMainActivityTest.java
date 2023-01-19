package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jetbrains.annotations.TestOnly;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);
        // button press
        scenario.onActivity((activity -> {
            var button_1 = (Button) activity.findViewById(R.id.btn_one);
            var button_plus = (Button) activity.findViewById(R.id.btn_plus);
            var button_equals = (Button) activity.findViewById(R.id.btn_equals);
            button_1.performClick();
            button_plus.performClick();
            button_1.performClick();
            button_equals.performClick();

            var text_displayed = (TextView) activity.findViewById(R.id.display);
            assertEquals("2", text_displayed.getText().toString());
        }));


    }

}
