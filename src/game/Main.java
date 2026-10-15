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
            map = new Map("map1");
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
        while (!map.hasWon())
        {
            map.printMap(player.getPosition());

            String input = validateInput();

            switch (input)
            {
                case "quit":
                    System.out.println("quitting...");
                    return;
                case "x":
                    if(player.canUndo()) {
                        player.undoMove();
                        map.undoMove(player.getPosition());
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
        System.out.println(map);
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
        String command = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Input a command: ");

        while (true)
        {
            command = input.nextLine().toLowerCase();

            for (String validCommand : validCommands)
            {
                if (command.equals(validCommand))
                {
                    input.close();

                    return command;
                }
            }

            System.out.println("Invalid command, try again: ");
        }
    }
}
