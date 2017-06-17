import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderedJobsTests
{
    @Test
    public void register_oneJob_storesOneJob()
    {
        char job = 'a';
        Map<Character, Character> expected = new HashMap();
        expected.put(job, null);

        OrderedJobs target = new OrderedJobs();
        target.register(job);

        Map<Character, Character> jobs = target.getInternalData();
        assertThat(jobs, is(expected));
    }

    @Test
    public void register_twoJobs_storesTwoJobs()
    {
        char job1 = 'a';
        char job2 = 'b';
        Map<Character, Character> expected = new HashMap();
        expected.put(job1, null);
        expected.put(job2, null);

        OrderedJobs target = new OrderedJobs();
        target.register(job1);
        target.register(job2);

        Map<Character, Character> jobs = target.getInternalData();
        assertThat(jobs, is(expected));
    }

    @Test
    public void register_oneDependentJob_storesOneDependentJob()
    {
        char dependentJob = 'a';
        char independentJob = 'b';
        Map<Character, Character> expected = new HashMap();
        expected.put(dependentJob, independentJob);

        OrderedJobs target = new OrderedJobs();
        target.register(dependentJob, independentJob);

        Map<Character, Character> jobs = target.getInternalData();
        assertThat(jobs, is(expected));
    }

    @Test
    public void sort_noJob_returnsEmptyString(){
        String expected = "";

        OrderedJobs target = new OrderedJobs();
        String actual = target.sort();

        assertThat(actual, is(expected));
    }

    @Test
    public void sort_oneJob_returnsOneJob(){
        char job1 = 'a';
        String expected = "a";

        OrderedJobs target = new OrderedJobs();
        Map<Character, Character> map = new HashMap<>();
        map.put(job1, null);
        target.setInternalData(map);
        String actual = target.sort();

        assertThat(actual, is(expected));
    }
}
