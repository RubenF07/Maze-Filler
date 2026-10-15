package game;

import java.util.*;
import java.io.FileNotFoundException;

/**
 * A tile-based game with the goal of activating each tile by lighting them up.
 * 
 * @author Group 13
 * @version 12 Oct 2026
 */
public class Main
{
    /**
     * four direction variables to work between classes and improve readability.
     */
    public static enum direction
    {
        UP,
        LEFT,
        DOWN,
        RIGHT;
    }

    // Scanner object for all user input
    private static final Scanner INPUT = new Scanner(System.in);

    /**
     * Main game loop and logic.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // variable setup
        Map map;
        try
        {
            map = new Map("map1.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Map import failed, shutting down.");
            return;
        }

        Player player = new Player(map.getPlayerStart());

        HashMap<String, direction> moves = new HashMap<>();
        moves.put("w", direction.UP);
        moves.put("a", direction.LEFT);
        moves.put("s", direction.DOWN);
        moves.put("d", direction.RIGHT);

        // main game loop
        while (!map.hasWon(player.getPosition()))
        {
            map.printMap(player.getPosition());

            String input = validateInput();

            switch (input)
            {
                case "quit":
                    System.out.println("quitting...");
                    return;
                case "x":
                    if (player.canUndo())
                    {
                        player.undoMove();
                        map.undoMove(player.getPosition());
                    }
                    else
                    {
                        System.out.println("No more moves to undo.");
                    }

                    break;
                default:
                    direction dir = moves.get(input);

                    if (map.canMove(player.getPosition(), dir))
                    {
                        map.playerMoved(player.getPosition());
                        player.move(dir);
                    }
                    else
                    {
                        System.out.println("You can't move there!");
                    }
            }
        }

        // win message and potential next level
        map.printMap(player.getPosition());
        System.out.println("You win!");
    }


    /**
     * Repeatedly takes user input to run game commands.
     * 
     * @return one of six valid commands (directions, undo, quit)
     */
    public static String validateInput()
    {
        String[] validCommands = { "w", "a", "s", "d", "x", "quit" };
        System.out.print("Input a command: ");

        while (true)
        {
            String command = INPUT.nextLine().toLowerCase().trim();
            for (String validCommand : validCommands)
            {
                if (command.equals(validCommand))
                {
                    return command;
                }
            }
            System.out.print("Invalid command, try again: ");
        }
    }
}
