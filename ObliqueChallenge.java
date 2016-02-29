/* ObliqueChallenge.java */

/**
 * @author __MadHatter (alias used on https://www.reddit.com/r/dailyprogrammer)
 *
 * [2016-02-17] Challenge #254 [Intermediate] Finding Legal Reversi Moves
 * https://www.reddit.com/r/dailyprogrammer/comments/468pvf/20160217_challenge_254_intermediate_finding_legal/
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ObliqueChallenge
{
    public ObliqueChallenge()
    {
        Scanner input = new Scanner(System.in);
        String line;
        StringTokenizer st;
        ArrayList<Integer> row;
        ArrayList<ArrayList> rows = new ArrayList<>();
        int n_elements = 0;

        /* Read input. */
        while ((line = input.nextLine()) != null && !line.isEmpty())
        {
            row = new ArrayList<>();
            st = new StringTokenizer(line);
            while (st.hasMoreTokens())
                row.add(Integer.parseInt(st.nextToken()));
            n_elements += row.size();
            rows.add(row);
        }

        /* Uncomment one of the following to see its output for given input. */
//        oblique(rows, n_elements);         /* input for oblique */
//        deoblique(rows, n_elements);       /* input for deoblique */
//        deoblique(3, 6, rows, n_elements); /* input for deoblique WIDE */
//        deoblique(6, 3, rows, n_elements); /* input for deoblique TALL */
    }

    private void oblique(ArrayList<ArrayList> rows, int n_elements)
    {
        int i;
        int count = 0;

        while (n_elements > 0)
        {
            count++;
            for (i = 0; i < count; i++)
            {
                if (i >= rows.size())
                    break;
                if (rows.get(i).size() > 0)
                {
                    System.out.print("" + rows.get(i).get(0) + " ");
                    rows.get(i).remove(0);
                    n_elements--;
                }
            }
            System.out.println();
        }
    }

    private void deoblique(ArrayList<ArrayList> rows, int n_elements)
    {
        int n_rows;
        if (rows.size() % 2 != 0)
            n_rows = (rows.size() + 1) / 2;
        else
            n_rows = rows.size() / 2;

        int n_cols = rows.get(0).size();
        for (int i = 1; i < rows.size(); i++)
        {
            if (rows.get(i).size() > n_cols)
                n_cols = rows.get(i).size();
        }

        deoblique(n_rows, n_cols, rows, n_elements);
    }

    private void deoblique(int n_rows, int n_cols, ArrayList<ArrayList> rows, int n_elements)
    {
        while (n_elements > 0)
        {
            for (int r = 0; r < n_cols; r++)
            {
                if (rows.get(r).isEmpty())
                    rows.remove(r);
                if (r >= rows.size())
                    break;
                System.out.print("" + rows.get(r).get(0) + " ");
                rows.get(r).remove(0);
                n_elements--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        new ObliqueChallenge();
    }
}
