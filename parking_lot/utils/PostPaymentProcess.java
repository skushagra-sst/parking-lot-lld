package parking_lot.utils;

public interface PostPaymentProcess {
    public PostPaymentProcess onSuccess(Runnable successCallback);

    public PostPaymentProcess onFailure(Runnable failureCallback);

    public void execute();
}
