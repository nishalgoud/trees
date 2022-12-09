import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class CFSScheduler {
    public static class Task implements Comparable<Task> {

        String name;
        int priority;
        int starttime;
        int burst;
        int waittime;
        int rrval;
        int schval;
    
        public Task(String n, int a, int b, int c) {
            name = n;
            priority = a;
            starttime = b;
            burst = c;
            waittime = 0;
            rrval = 0;
            schval = 0;
        }
    
        public int compareTo(Task a) {
            return burst - a.burst;
        }
    }
  
    public static class WaitCmp implements Comparator<Task> {
        public int compare(Task a, Task b) {
            if (a.starttime < b.starttime) return -1;
            if (a.starttime > b.starttime) return 1;
            return 0;
        }
    }
    

public static class HPCmp implements Comparator<Task> {
    public int compare(Task a, Task b) {
        if (a.burst < b.burst) return -1;
        if (a.burst > b.burst) return 1;
        if (a.burst == b.burst) {
            if (a.schval < b.schval) return -1;
            if (a.schval > b.schval) return 1;
        }
        return 0;
    }
}

public static class Scheduler {
    ArrayList<Task> tasks = new ArrayList<Task>();
    ArrayList<Task> waitinghigh = new ArrayList<Task>();
    ArrayList<Task> waitinglow = new ArrayList<Task>();
    Task current = null;
    int cnt = 0;
    String order = "";

    public void schedule() {
        while (true) {
            Task temp = null;
            for (int i = 0; i != tasks.size(); i++) {
                Task t = tasks.get(i);
                if (current == null) {
                    current = new Task("Z", 1, 0, 0);
                }
                if (cnt == t.starttime) {
                    if (t.priority == 0) {
                        if (current.priority == 0 && t.burst < current.burst) {
                            current.schval = cnt;
                            waitinghigh.add(current);
                            Collections.sort(waitinghigh, new HPCmp());
                            current = t;
                        }
                        if (current.priority == 0 && t.burst >= current.burst && current != t) {
                            waitinghigh.add(t);
                            Collections.sort(waitinghigh, new HPCmp());
                        }
                        if (current.priority == 1) {
                            current.rrval = 0;
                            temp = current;
                            current = t;
                        }
                    } else {
                        if (current != t) {
                            waitinglow.add(t);
                        }
                    }
                }
            }
            if (temp != null && temp.burst > 0) {
                waitinglow.add(temp);
                temp = null;
            }
            if (current.priority == 0) {
                if (current.burst < 1) {
                    if (waitinghigh.size() != 0) {
                        current = waitinghigh.remove(0);
                    } else {
                        if (waitinglow.size() != 0) {
                            current = waitinglow.remove(0);
                        } else {
                            current = new Task("Z", 1, 0, 0);
                            cnt++;
                            continue;
                        }
                    }
                }
            } else {
                if (current.burst < 1) {
                    if (waitinghigh.size() != 0) {
                        current = waitinghigh.remove(0);
                    } else {
                        if (waitinglow.size() != 0) {
                            current = waitinglow.remove(0);
                        } else {
                            current = new Task("Z", 1, 0, 0);
                            cnt++;
                            continue;
                        }
                    }
                }
                if (current.priority == 1 && current.burst > 0) {
                    if (current.rrval == 2) {
                        current.rrval = 0;
                        if (waitinglow.size() != 0) {
                            current.schval = cnt;
                            waitinglow.add(current);
                            current = waitinglow.remove(0);
                        }
                    }
                }
            }
            if (current.burst > 0)
                current.burst--;
            if (current.priority == 1 && current.rrval < 2)
                current.rrval++;
            if (order.length() < 1 || !order.endsWith(current.name))
                order = order.concat(current.name);
            addwait();
            cnt++;
            if (waitinghigh.size() == 0 && waitinglow.size() == 0 && cnt > (tasks.get(tasks.size() - 1).starttime + tasks.get(tasks.size() - 1).burst) && current.burst < 1)
                return;
        }
    }

    public void addwait() {
        for (int i = 0; i < waitinglow.size(); i++) {
            for (int j = 0; j < tasks.size(); j++) {
                if (waitinglow.get(i).name == tasks.get(j).name)
                    tasks.get(j).waittime++;
            }
        }
        for (int i = 0; i < waitinghigh.size(); i++) {
            for (int j = 0; j < tasks.size(); j++) {
                if (waitinghigh.get(i).name == tasks.get(j).name)
                    tasks.get(j).waittime++;
            }
        }
    }

    public void read() {
        Scanner in = new Scanner(System.in);
        while (true) {
            if (!in.hasNext()) {
                break;
            }
            String line = in.nextLine();
            if (line == null) {
                break;
            }
            line = line.trim();
            if (line.isEmpty()) {
                break;
            }
            String[] data = line.split(",");
            tasks.add(new Task(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }
        in.close();
    }

    public void execute() {
        read();
        schedule();
        System.out.println(order);
        String waitorder = "";
        Collections.sort(tasks, new WaitCmp());
        for (int i = 0; i < tasks.size(); i++) {
            waitorder = waitorder.concat(tasks.get(i).name + ":" + tasks.get(i).waittime + ",");
        }
        waitorder = waitorder.substring(0, waitorder.length() - 1);
        System.out.println(waitorder);
    }
}

    public static void main(String[] args){
        Scheduler s = new Scheduler();
        s.execute();
    }
    
}
