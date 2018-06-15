package view.FieldForGame;


import Factory.FactoryWork;
import exception.InvalidArgs;
import exception.MyException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class GameField extends JPanel
{
    public static BufferedImage background = null;
    ArrayList<Cell> ListOfCell=new ArrayList<>();
    private int rows;
    private int cols;
    private int active_cell=0;

    static{
        try {
            InputStream is = GameField.class.getResourceAsStream("/res/" + "background.png");
            background = ImageIO.read(is);
        }   catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public GameField()
    {
        setPreferredSize(new Dimension(340,455 ));
    }

    public void initCells(int user_rows,int user_cols )
    {
        rows=user_rows;
        cols=user_cols;
        setLayout(new GridLayout(rows, cols, 0, 0));
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
            {
                Cell cell = new Cell();
                cell.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                cell.setOpaque(false);
                this.add(cell);
                ListOfCell.add(i * rows + j, cell);
            }
        setVisible(false);
        setVisible(true);
    }

    public void action_job(String command, String[] args) throws MyException
    {
        FactoryWork.create(command.toUpperCase()).execute(args, this);
    }

    public void putTurtle(int x, int y) throws MyException
    {
        if(ListOfCell.get(active_cell).isTurtle())
            ListOfCell.get(active_cell).rem_turt();
        if(x > rows || y > cols)
        {
            ListOfCell.get(active_cell=0).load_turt();
            throw new InvalidArgs("put turtle'. Wrong coords: " + x + " " + y+". Turtle put in 0:0");
        }
        active_cell=y*rows+x;
        ListOfCell.get(active_cell).load_turt();
        repaint();
    }

    public Cell getTurtle()
    {
        return ListOfCell.get(active_cell);
    }

    public void moveTurtle(char direct)
    {

        Cell cell = ListOfCell.get(active_cell);
        switch (direct)
        {
            case 'U':
                if (active_cell >= rows)
                    active_cell -= rows;
                else
                    active_cell=rows*cols-(rows-active_cell);
                break;
            case 'D':
                if (active_cell < rows * (cols - 1))
                    active_cell += rows;
                else
                    active_cell=active_cell%rows;
                break;
            case 'L':
                if (active_cell % rows != 0)
                    active_cell--;
                else
                    active_cell+=(rows-1);
                break;
            case 'R':
                if (active_cell % rows + 1 != rows)
                    active_cell++;
                else
                    active_cell-=(rows-1);
                break;
        }
        if (cell.isDraw()) {
            cell.setPainted(true);
            cell.setOpaque(true);
            cell.setBackground(Color.PINK);
        }
        if(!cell.isDraw()){
            cell.setBackground(null);
        }
        repaint();
    }
    private int getRows()
    {
        return rows;
    }
    private int getCols()
    {
        return cols;
    }
    public void clear()
    {
        if(ListOfCell.isEmpty())
            return;
        for(Cell cell: ListOfCell)
        {
            cell.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            cell.setOpaque(false);
            cell.setPainted(false);
        }
        ListOfCell.get(active_cell).rem_turt();
        active_cell=0;
        ListOfCell.get(active_cell).load_turt();
    }
    public boolean isEmpty()
    {
        return ListOfCell.isEmpty();
    }

    public void deleteListOfCell()
    {
        ListOfCell.get(active_cell).rem_turt();
        ListOfCell.clear();
        active_cell=0;
        removeAll();
    }

    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 7, 7, this);
}

    /*public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if(obj==null)
            return false;
        if(!(obj instanceof GameField))
            return false;
        GameField other= (GameField)obj;
        if (this.isEmpty()==other.isEmpty())
            return true;
        if(this.getCols()==other.getCols() && this.getRows()==other.getRows())
        {
            for(int i=0;i<ListOfCell.size();i++)
            {
                if(this.ListOfCell.get(i).isColored()!=other.ListOfCell.get(i).isColored())
                    return false;
            }
            if(active_cell!=other.active_cell)
                return false;
            return true;
        }
        else
            return false;
    }*/


}
