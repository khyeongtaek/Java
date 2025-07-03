package chap10_instance_array.chap09_instance_array;

public class Bus {

    private Seat[] seats;
    private int count;
    private final int LIMIT = 5;

    public Bus() {
        this.seats = new Seat[LIMIT];
        for (int i = 0; i < LIMIT; i++) {
            seats[i] = new Seat();
        }
        this.count = 0;
    }

    public Seat[] getSeats() {
        return seats;
    }
    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public void seatInfo(){
        for(int i = 0; i < LIMIT; i++){
            Person person = seats[i].getPerson();
            if (person == null) {
                System.out.println(String.format("%d",i+1)+ "번 좌석: 비어있음");
            }else {
                System.out.println(String.format("%d",i+1)+ "번 좌석: "+ person.getName());
            }
        }
    }

    // 버스 탑승
    public void on(Person person) {
        if (count == LIMIT) {
            System.out.println("다음버스 타세요");
            return;
        }
        for (int i = 0; i < LIMIT; i++) {
            if (seats[i].getPerson() == null) {
                System.out.println(person.getName() + "님 탑승.");
                seats[i].setPerson(person);
                count++;
                break;
            }
        }
    }

    // 버스 하차
    public void off(int idx) {
        if (count == 0) {
            System.out.println("버스가 비어있습니다.");
            return;
        }
        if (idx <= 0 || idx >= count || seats[idx].getPerson() == null) {
            System.out.println(idx + "는 하차 불가능한 좌석번호 입니다.");
            return;
        }
        System.out.println(seats[idx].getPerson().getName() + "님이 하차함");
        seats[idx-1].setPerson(null);
    }



}
