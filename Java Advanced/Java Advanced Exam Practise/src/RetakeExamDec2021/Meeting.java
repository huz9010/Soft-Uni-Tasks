package RetakeExamDec2021;

import java.util.*;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> malesStack.push(Integer.valueOf(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> femalesQueue.offer(Integer.valueOf(e)));

        int matches = 0;

        int male = malesStack.peek();
        int female = femalesQueue.peek();

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty())    {

            if (male <= 0)  {
                malesStack.pop();
                if (malesStack.isEmpty())   {
                    break;
                }   else {
                    male = malesStack.peek();
                    continue;
                }
            }

            if (female <= 0)  {
                femalesQueue.poll();
                if (femalesQueue.isEmpty())   {
                    break;
                }   else {
                    female = femalesQueue.peek();
                    continue;
                }
            }

            if (male % 25 == 0)   {
                malesStack.pop();
                if (malesStack.isEmpty())   {
                    break;
                }   else {
                    malesStack.pop();
                }
                if (malesStack.isEmpty())   {
                    break;
                }   else {
                    male = malesStack.pop();
                    continue;
                }
            }

            if (female % 25 == 0)   {
                femalesQueue.poll();
                if (femalesQueue.isEmpty())   {
                    break;
                }   else {
                    femalesQueue.poll();
                }
                if (femalesQueue.isEmpty())  {
                    break;
                }   else {
                    female = femalesQueue.peek();
                    continue;
                }
            }

            if (male == female)  {
                matches++;
                malesStack.pop();
                femalesQueue.poll();

                if (malesStack.isEmpty() || femalesQueue.isEmpty()) {
                    break;
                }
                male = malesStack.peek();
                female = femalesQueue.peek();
            }   else {
                    male -= 2;
                    malesStack.pop();
                    malesStack.push(male);

                    femalesQueue.poll();
                    if (femalesQueue.isEmpty()) {
                        break;
                    }
                    female = femalesQueue.peek();
            }


        }
        System.out.println("Matches: " + matches);
        System.out.println(malesStack.isEmpty() ? "Males left: none" : "Males left: " + malesStack.stream().collect(Collectors.toList())
                .stream().map(Objects::toString).collect(Collectors.joining(", ")));
        System.out.println(femalesQueue.isEmpty() ? "Females left: none" : "Females left: " + femalesQueue.stream().collect(Collectors.toList())
                .stream().map(Objects::toString).collect(Collectors.joining(", ")));
    }
}
