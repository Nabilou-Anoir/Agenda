package agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Repetition {
    /**
     * Stores the frequency of this repetition, one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    private final ChronoUnit myFrequency;

    /**
     * List of exceptions for this repetition.
     */
    private final List<LocalDate> exceptions = new ArrayList<>();

    /**
     * Termination conditions for this repetition
     */
    private Termination termination = null;

    /**
     * Constructor to define the frequency of repetition
     * @param myFrequency the frequency of repetition
     */
    public Repetition(ChronoUnit myFrequency) {
        this.myFrequency = myFrequency;
    }

    /**
     * @return the frequency of repetition
     */
    public ChronoUnit getFrequency() {
        return myFrequency;
    }

    /**
     * Adds an exception to the repetition
     * @param date a date where the event should not repeat
     */
    public void addException(LocalDate date) {
        exceptions.add(date);
    }

    /**
     * Sets the termination of this repetition
     * @param termination the termination of the repetition
     */
    public void setTermination(Termination termination) {
        this.termination = termination;
    }

    /**
     * Checks if a given date is an exception
     * @param date the date to check
     * @return true if the date is an exception, false otherwise
     */
    public boolean isException(LocalDate date) {
        return exceptions.contains(date);
    }

    /**
     * @return the termination of this repetition
     */
    public Termination getTermination() {
        return termination;
    }
}