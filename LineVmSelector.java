import java.util.*;
import java.util.stream.Collectors;

class LineVM {
    private String msisdn;
    private String billingAccountId;
    private String state;
    private Long activationDate;

    // Constructor
    public LineVM(String msisdn, String billingAccountId, String state, Long activationDate) {
        this.msisdn = msisdn;
        this.billingAccountId = billingAccountId;
        this.state = state;
        this.activationDate = activationDate;
    }

    // Getters
    public String getMsisdn() { return msisdn; }
    public String getBillingAccountId() { return billingAccountId; }
    public String getState() { return state; }
    public Long getActivationDate() { return activationDate; }

    @Override
    public String toString() {
        return "LineVM{msisdn='" + msisdn + "', state='" + state + "', activationDate=" + activationDate + "}";
    }
}

class DataValidationWrapper {
    private String billingAccountId;

    public DataValidationWrapper(String billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public String getBillingAccountId() { return billingAccountId; }
}

public class LineVmSelector {

    public static List<LineVM> selectLineVms(List<LineVM> lineVmsFromInput, DataValidationWrapper dataValidationWrapper) {
        Set<String> inactiveStates = new HashSet<>(Arrays.asList("INACTIVE", "CANCELLED"));
//
//
//        Map<String, List<LineVM>> lineVmByMsisdn = lineVmsFromInput.stream()
//                .filter(lineVM -> Objects.equals(lineVM.getBillingAccountId(), dataValidationWrapper.getBillingAccountId()))
//                .collect(Collectors.groupingBy(LineVM::getMsisdn));
//
//        return lineVmByMsisdn.values().stream()
//                .map(lineVmList -> {
//                    Optional<LineVM> activeLineVm = lineVmList.stream()
//                            .filter(lineVM -> !inactiveStates.contains(lineVM.getState()))
//                            .findFirst();
//
//                    return activeLineVm.orElseGet(() ->
//                            lineVmList.stream()
//                                    .max(Comparator.comparing(LineVM::getActivationDate, Comparator.nullsFirst(Comparator.naturalOrder())))
//                                    .orElse(null)
//                    );
//                })
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
        System.out.println("Inside selectLineVms and lineVmsFromInput size: "+lineVmsFromInput.size());

        System.out.println("Selected lineVmsFromInput " + lineVmsFromInput.stream()
                .map(lineVM -> Arrays.asList(lineVM.getMsisdn(), lineVM.getBillingAccountId()))
                .collect(Collectors.toList()));

        //Set<String> inactiveStates = Set.of("INACTIVE", "CANCELLED");

        Map<String, List<LineVM>> lineVmByMsisdn = lineVmsFromInput.stream().filter(
                        lineVM -> Objects.equals(lineVM.getBillingAccountId(), dataValidationWrapper.getBillingAccountId()))
                .collect(Collectors.groupingBy(LineVM::getMsisdn));

        System.out.println("Selected lineVmsFromInput " + lineVmByMsisdn.values().stream()
                .map(lineVMList -> Arrays.asList(lineVMList.stream().map(lineVM -> Arrays.asList(lineVM.getMsisdn(), lineVM.getBillingAccountId()))))
                .collect(Collectors.toList()));

        List<LineVM> selectedLineVmList = lineVmByMsisdn.values().stream().map(lineVmList -> {
                    Optional<LineVM> activeLineVm = lineVmList.stream()
                            .filter(lineVM -> !inactiveStates.contains(lineVM.getState())).findFirst();

                    System.out.println("activeLineVm : "+activeLineVm);

                    return activeLineVm.orElseGet(() -> lineVmList.stream().max(
                                    Comparator.comparing(LineVM::getActivationDate, Comparator.nullsFirst(Comparator.naturalOrder())))
                            .orElse(null)
                    );
                }).filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println("selectLineVms Size :"+selectedLineVmList.size());
        System.out.println(selectedLineVmList.stream()
                .map(lineVM -> String.format("lineId: %s, billingLineId: %s", lineVM.getMsisdn(), lineVM.getBillingAccountId()))
                .collect(Collectors.toList()));
        return selectedLineVmList;
    }

    public static void main(String[] args) {
        List<LineVM> lineVmsFromInput = Arrays.asList(
                new LineVM("123456789", "BA1001", "INACTIVE", 1704854400000L), // 2024-01-10
                new LineVM("123456789", "BA1001", "ACTIVE", 1707955200000L), // 2024-02-15 (Selected)

                new LineVM("987654321", "BA1001", "CANCELLED", 1709616000000L), // 2024-03-05 (Selected)
                new LineVM("987654321", "BA1001", "INACTIVE", 1972531200000L), // 2023-01-01

                new LineVM("555555555", null, "INACTIVE", 1713571400000L),
                new LineVM("555555555", "BA1002", "CANCELLED", 1713571200000L),
                new LineVM("555555555", "BA1002", "ACTIVE", 1713571200000L)
        );

        DataValidationWrapper dataValidationWrapper = new DataValidationWrapper("BA1002");

        List<LineVM> selectedLineVms = selectLineVms(lineVmsFromInput, dataValidationWrapper);

        System.out.println("Selected LineVMs:");
        selectedLineVms.forEach(System.out::println);
    }
}
