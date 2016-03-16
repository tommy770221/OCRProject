import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.OCRScanner;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.TrainingImage;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.TrainingImageLoader;
import net.sourceforge.javaocr.scanner.PixelImage;
public class TestCon2 {

	public static void main(String[] args) throws IOException {
		 OCRScanner scanner = new OCRScanner();
	        TrainingImageLoader loader = new TrainingImageLoader();
	        HashMap<Character, ArrayList<TrainingImage>> trainingImageMap = new HashMap<Character, ArrayList<TrainingImage>>();
	        loader.load("D:\\OCRProject\\demos\\trainer\\src\\main\\java\\123.png", new CharacterRange('0', '8'), trainingImageMap);
	        loader.load("D:\\OCRProject\\demos\\trainer\\src\\main\\java\\4c4RL.png", new CharacterRange('!', '~'), trainingImageMap);

	        scanner.addTrainingImages(trainingImageMap);

	        Image image = ImageIO.read(new File("D:\\OCRProject\\demos\\trainer\\src\\main\\java\\test2.png"));
	        PixelImage pixelImage = new PixelImage(image);
	        pixelImage.toGrayScale(true);
	        pixelImage.filter();
	        CharacterRange[] acceptableChars=new CharacterRange[1];
	        acceptableChars[0]=new CharacterRange('0','9');
	        String text = scanner.scan(image, 0, 0, 0, 0, acceptableChars);
	        System.out.println(text);

	}

}
