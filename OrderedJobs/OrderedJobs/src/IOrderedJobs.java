interface IOrderedJobs
{
    void register(char dependentJob, char independentJob);

    void register(char job);

    String sort();
}