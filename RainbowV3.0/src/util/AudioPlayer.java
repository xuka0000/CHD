package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * ʹ���̲߳��������ļ��Ĺ�����
 * ����Ҫ��ע���ʵ�֣�ֻ��Ҫ��ע���ʹ�ñ������������ּ���
 * @author ��ͷ
 *
 */
public class AudioPlayer extends Thread{
	Player player;
	File musicFile;
	
	public AudioPlayer(File file) {
		if(null == file || !file.exists()) {
			throw new RuntimeException("�����ļ������ڣ��޷����ţ�");
		}
		this.musicFile = file;
		
	}
	
	public AudioPlayer(String filePath) {
		this(new File(filePath));
	}
	
	@Override
	public void run() {
		try {
			play();
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public void stopMusic() {
		player.close();
	}
	
	public void play() throws FileNotFoundException, JavaLayerException {
		BufferedInputStream instream = new BufferedInputStream(new FileInputStream(musicFile));
		player = new Player(instream);
		
		player.play();
	}
}
