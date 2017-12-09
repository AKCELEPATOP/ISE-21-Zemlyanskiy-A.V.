package main;

import java.awt.*;
import java.io.*;
import java.util.*;

import components.DepoIndexOutOfRangeException;
import components.DepoOverflowException;
import components.Rotate;
import train.ITransport;

public class Depo {

	ArrayList<ClassArray<ITransport>> depoStages;

	int countPlaces = 10;

	int placeSizeWidth = 50;

	int placeSizeHeight = 120;
	
	int currentLevel;

	public Depo(int countStages) {
		depoStages = new ArrayList<>();
		for(int i=0;i<countStages;++i){
			depoStages.add(new ClassArray<ITransport>(countPlaces,null));
		}
	}
	
	public boolean SaveData(File file){
		if(file.exists()){
			file.delete();
		}
		try(ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
    		out.writeObject(depoStages);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean LoadData(File file){
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
			depoStages=(ArrayList<ClassArray<ITransport>>)in.readObject();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public int getCurrentLevel(){
		return currentLevel;
	}
	
	public void setCurrentLevel(int currentLevel){
		this.currentLevel=currentLevel;
	}

	public int PutLocInDepo(ITransport loc) throws DepoOverflowException {
		return depoStages.get(currentLevel).Add(loc);

	}

	public ITransport GetLocInDepo(int index) throws DepoIndexOutOfRangeException {
		return depoStages.get(currentLevel).Get(index);
	}

	public void Draw(Graphics2D g) {
		DrawMarking(g);
		
		for(int i = 0; i < countPlaces; ++i)
        {
            ITransport loc = depoStages.get(currentLevel).GetLoc(i);
            if (loc != null)
            {
            	loc.setPosition(61 + i % 5 * (placeSizeWidth + 20), 120 + i / 5 * placeSizeHeight);
                Rotate.imageRotate(g, loc.Pict(), (i < 5) ? Math.PI : 0, loc.Center());
            }
        }
	}

	public void DrawMarking(Graphics2D g) {

		int step = 50;
		int railWidth = 20;
		int railLength = placeSizeHeight + 50;
		int space = 20;
		int beamStep = 10;

		Point[] rail = new Point[4];
		rail[0] = new Point(step, 0);
		rail[2] = new Point(rail[0].x + railWidth, 0);
		rail[1] = new Point(rail[0].x, rail[0].y + railLength);
		rail[3] = new Point(rail[2].x, rail[1].y);
		
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < countPlaces >> 1; ++j) {
				g.setStroke(new BasicStroke(5.0f));
				g.setColor(new Color(137,91,65));
				for (int z = 0; z < railLength / beamStep; ++z) {
					g.drawLine(rail[0].x + (railWidth + step) * j - 2,
							rail[0].y + (railLength + space) * i + 5 + z * beamStep,
							rail[2].x + (railWidth + step) * j + 3,
							rail[2].y + (railLength + space) * i + 5 + z * beamStep);
				}
				g.setStroke(new BasicStroke(3.0f));
				g.setColor(Color.GRAY.brighter());
				g.drawLine(rail[0].x + (railWidth + step) * j, rail[0].y + (railLength + space) * i,
						rail[1].x + (railWidth + step) * j, rail[1].y + (railLength + space) * i);
				g.drawLine(rail[2].x + (railWidth + step) * j, rail[2].y + (railLength + space) * i,
						rail[3].x + (railWidth + step) * j, rail[3].y + (railLength + space) * i);
			}
		}

	}

}
