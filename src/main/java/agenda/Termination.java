package agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Termination {

    /**
     * The start date of the event
     */
    private final LocalDate start;

    /**
     * The frequency of the event's repetition
     */
    private final ChronoUnit frequency;

    /**
     * The termination date (inclusive) for this repetition
     */
    private final LocalDate terminationInclusive;

    /**
     * The number of occurrences for this repetition
     */
    private final int numberOfOccurrences;

    /**
     * Constructs a fixed termination event ending at a given date
     * @param start the start time of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     * @see ChronoUnit#between(Temporal, Temporal)
     */
    public Termination(LocalDate start, ChronoUnit frequency, LocalDate terminationInclusive) {
        this.start = start;
        this.frequency = frequency;
        this.terminationInclusive = terminationInclusive;
        this.numberOfOccurrences = (int) frequency.between(start, terminationInclusive) + 1;
    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     * @param start the start time of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public Termination(LocalDate start, ChronoUnit frequency, long numberOfOccurrences) {
        this.start = start;
        this.frequency = frequency;
        this.numberOfOccurrences = (int) numberOfOccurrences;
        this.terminationInclusive = start.plus(numberOfOccurrences - 1, frequency);
    }

    /**
     * Returns the termination date (inclusive)
     * @return the termination date
     */
    public LocalDate getTerminationDate() {
        return terminationInclusive;
    }

    /**
     * Returns the number of occurrences of the event
     * @return the number of occurrences
     */
    public int getNumberOfOccurrences() {
        return numberOfOccurrences;
    }

    /**
     * Checks if a given date is after the termination date
     * @param date the date to check
     * @return true if the date is after the termination date
     */
    public boolean isAfter(LocalDate date) {
        return date.isAfter(terminationInclusive);
    }

}