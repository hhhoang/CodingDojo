import java.util.HashMap;
import java.util.Map;

public class OrderedJobs implements IOrderedJobs
{
    Map<Character,Character> mJobs = new HashMap<>();

    @Override
    public void register(char dependentJob, char independentJob)
    {
        mJobs.put(dependentJob, independentJob);
    }

    @Override
    public void register(char job)
    {
        mJobs.put(job, null);
    }

    @Override
    public String sort()
    {
        return "";
    }

    public Map<Character, Character> getInternalData()
    {
        return mJobs;
    }

    public void setInternalData(Map<Character, Character> map)
    {
        mJobs = map;
    }
}
