package step3;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarGame {
    private List<RacingCar> racingCarList;
    private Attempt attempt;
    private RamdomCondition ramdomCondition;
    private Random random;

    RacingCarGame() {
        this.ramdomCondition = new RamdomCondition();
        this.random = new Random();
    }

    public boolean ready(int carCount, int attemptCount) {
        racingCarList = new ArrayList<>(carCount);

        while (racingCarList.size() != carCount) {
            racingCarList.add(new RacingCar());
        }

        attempt = new Attempt(attemptCount);

        return isRacingCarReady(carCount) && isAttemptReady(attemptCount);
    }


    public boolean ready(String allRacingCarName, int attemptCount) {
        String[] raicingCarNames = allRacingCarName.split(",");

        racingCarList = Arrays.stream(raicingCarNames)
                .map(n -> new RacingCar(n))
                .collect(Collectors.toList());

        attempt = new Attempt(attemptCount);

        return isRacingCarReady(raicingCarNames.length) && isAttemptReady(attemptCount);
    }

    //racingCars로 비교 가능
    public boolean isRacingCarReady(int carCount) {
        return racingCarList.size() == carCount;
    }

    //equals로 비교 가능
    public boolean isAttemptReady(int attemptCount) {
        return attempt.isEqualNumber(attemptCount);
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public void play() {
        for (RacingCar racingCar : racingCarList) {
           racingCar.move(this.ramdomCondition);
        }
        attempt.make();
    }

    /*public void play() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.move();
        }
        attempt.make();
    }*/

    public List<RacingCar> findWinner() {
        Optional<Integer> topDistance = racingCarList.stream()
                .map(RacingCar::getDistance)
                .reduce(Integer::max);

        return racingCarList.stream()
                .filter(r -> topDistance.get() == r.getDistance())
                .collect(Collectors.toList());
    }

}
