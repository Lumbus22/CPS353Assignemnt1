import java.util.List;

public interface SourceInterface {
  void setInputSource(List<Integer> inputData);
  void setOutputSource(List<String> outputSource);
}

public class InputConfig implements SourceInterface {
  private List<Integer> inputData;

  @Override
  public void setInputSource(List<Integer> inputData) {
    this.inputData = inputData;
  }

  public List<Integer> getInputData() {
    return inputData;
  }
}

public class OutputConfig implements SourceInterface {
  private List<String> outputData;

  @Override
  public void setOutputSource(List<String> outputData) {
    this.outputData = outputData;
  }

  public List<String> getOutputData() {
    return outputData;
  }
}

