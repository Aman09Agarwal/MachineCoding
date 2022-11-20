import java.util.*;

class Pair {
    int doctorId;
    int slotNumber;

    public Pair(int doctorId, int slotNumber) {
        this.doctorId = doctorId;
        this.slotNumber = slotNumber;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "slotNumber=" + slotNumber +
                ", doctorId=" + doctorId +
                '}';
    }
}

class SortBySlot implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.slotNumber - b.slotNumber;
    }
}

class SortByDoctorId implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return b.doctorId - a.doctorId;
    }
}

public class Practice {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(1, 2, 4, 5));
        map.put(2, Arrays.asList(2, 5, 8));
        map.put(3, Arrays.asList(1, 3, 7, 9));
        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            entry.getValue().stream().forEach(x -> list.add(new Pair(entry.getKey(), x)));
        }
        Collections.sort(list, new SortByDoctorId());
        Collections.sort(list, new SortBySlot());
        list.stream().forEach(x -> System.out.println(x));
    }
}
