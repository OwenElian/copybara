import com.google.copybara.testing.DummyRevision;
    options = new OptionsBuilder()
        .setConsole(console)
        .setOutputRootToTmpDir();
  private void process(Destination.Writer writer, DummyRevision originRef)
  private void processWithBaseline(Destination.Writer writer, DummyRevision originRef,
      DummyRevision originRef,
        new DummyRevision("origin_ref"));
        new DummyRevision("origin_ref"),
        new DummyRevision("origin_ref1"),
        new DummyRevision("origin_ref2"),
        new DummyRevision("origin_ref"),
    DummyRevision ref = new DummyRevision("origin_ref");
    process(destination().newWriter(destinationFiles), new DummyRevision("origin_ref"));
    process(destination().newWriter(destinationFiles), new DummyRevision("origin_ref"));
        new DummyRevision("origin_ref"));
    process(destination().newWriter(destinationFiles), new DummyRevision("origin_ref"));
        new DummyRevision("origin_ref"));
    DummyRevision ref1 = new DummyRevision("first");
    DummyRevision ref2 = new DummyRevision("second");
    process(writer, new DummyRevision("first_commit"));
    process(writer, new DummyRevision("second_commit"));
    process(writer, new DummyRevision("third_commit"));
        new DummyRevision("first_commit"));
        new DummyRevision("first_commit"));
        new DummyRevision("first_commit").withTimestamp(Instant.ofEpochSecond(1414141414)));
        new DummyRevision("second_commit").withTimestamp(Instant.ofEpochSecond(1515151515)));
        new DummyRevision("first_commit"));
        new DummyRevision("first_commit").withTimestamp(Instant.ofEpochSecond(1414141414)));
        new DummyRevision("second_commit").withTimestamp(Instant.ofEpochSecond(1414141490)));
        new DummyRevision("first_commit").withTimestamp(Instant.ofEpochSecond(1414141414)));
        new DummyRevision("second_commit").withTimestamp(Instant.ofEpochSecond(1414141490)));
        new DummyRevision("first_commit"));
        new DummyRevision("first_commit"));
    DummyRevision firstCommit = new DummyRevision("first_commit")
    process(destination().newWriter(destinationFiles), new DummyRevision("ref"));
    process(destination().newWriter(destinationFiles), new DummyRevision("ref"));
    DummyRevision ref = new DummyRevision("origin_ref");
    DummyRevision ref = new DummyRevision("origin_ref");
    DummyRevision ref = new DummyRevision("origin_ref");
        writer.write(TransformResults.of(workdir, new DummyRevision("ref1")), console);
    result = writer.write(TransformResults.of(workdir, new DummyRevision("ref2")), console);
    DummyRevision ref = new DummyRevision("origin_ref");
    DummyRevision ref = new DummyRevision("origin_ref");
    DummyRevision ref1 = new DummyRevision("origin_ref1");
    DummyRevision ref2 = new DummyRevision("origin_ref2");