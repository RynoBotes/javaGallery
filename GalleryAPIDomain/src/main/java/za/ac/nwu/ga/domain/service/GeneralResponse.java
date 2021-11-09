package za.ac.nwu.ga.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable
{
    private static final long serialVersionUID = 194240556062590168L;


    private final boolean successful;
    private final transient T payload;

    public GeneralResponse(boolean successful, T payload)
    {
        this.payload = payload;
        this.successful = successful;
    }


    public boolean isSuccessful() {
        return successful;
    }


    public T getPayload() {
        return payload;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return successful == that.successful && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(successful, payload);
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "successful=" + successful +
                ", payload=" + payload +
                '}';
    }
}
