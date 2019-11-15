package war;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class ColdCallerTest {

    @Test(expected = IllegalArgumentException.class)
    public void getStudentNameShouldThrowInvalidArgumentExceptionWhenCalledWithNull() {
        ColdCaller caller = new ColdCaller();

        caller.getStudentName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getStudentNameShouldThrowInvalidArgumentExceptionWhenCalledWithEmptyArray() {
        ColdCaller caller = new ColdCaller();

        caller.getStudentName(new String[0]);
    }

    @Test
    public void getStudentNameShouldReturnTheOnlyNameForOneStudentSentIn() {
        ColdCaller caller = new ColdCaller();
        String[] names = new String[1];
        names[0] = "Tom";

        String called = caller.getStudentName(names);

        assertEquals(called, names[0]);
    }

    @Test
    public void getStudentNameShouldReturnNameForMultipleStudentsButNotReturnSameName() {
        ColdCaller caller = new ColdCaller();
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Tom's little brother Nemo");
        names.add("Tom's cousin Antwoinetta");
        String called = caller.getStudentName(names.toArray(new String[0]));

        assertThat(names, hasItem(called));

        List<String> calledNames = new ArrayList<>();
        calledNames.add(called);

        called = caller.getStudentName(names.toArray(new String[0]));

        assertThat(names, hasItem(called));
        assertFalse(calledNames.contains(called));

    }

    @Test
    public void getStudentNameShouldReturnNameForMultipleStudentsButNotReturnSameNameAndAlsoLoopAfterAllAreCalled() {
        ColdCaller caller = new ColdCaller();
        List<String> names = new ArrayList<>();
        List<String> calledNames = new ArrayList<>();
        names.add("Tom");
        names.add("Tom's little brother Nemo");
        names.add("Tom's cousin Antwoinetta");

        //get name and make sure we get a name from the array
        String called = caller.getStudentName(names.toArray(new String[0]));

        assertThat(names, hasItem(called));

        calledNames.add(called);

        //get name and make sure we get a name from the array, but not one we already got
        called = caller.getStudentName(names.toArray(new String[0]));

        assertThat(names, hasItem(called));
        assertFalse(calledNames.contains(called));

        calledNames.add(called);

        //get name and make sure we get a name from the array, but not one we already got
        called = caller.getStudentName(names.toArray(new String[0]));

        assertThat(names, hasItem(called));
        assertFalse(calledNames.contains(called));

        calledNames.add(called);

        //get name and make sure we get a name from the array after we called all names
        called = caller.getStudentName(names.toArray(new String[0]));

        assertThat(names, hasItem(called));

    }

}
