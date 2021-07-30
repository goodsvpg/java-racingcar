package CarRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private Random random = new Random();

    public Cars(int carCount) {
        if (carCount < 1) {
            throw new IllegalArgumentException("자동차 개수는 0이하의 수를 허용하지 않습니다.");
        }
        addCar(carCount);
    }

    private void addCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void moveAll() {
        cars.forEach(s -> s.move(random.nextInt(10)));
    }

    public List<Car> getCars() {
        return cars;
    }
}
