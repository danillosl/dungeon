package com.company.dungeon.save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class SaveRepositoryImpl implements SaveRepository {

	private static final SaveRepositoryImpl instance = new SaveRepositoryImpl();

	private SaveRepositoryImpl() {
	}

	private static final String SAVE_FOLDER = "dungeon_save";
	private static final String SAVE_EXTENSION = "save";

	@Override
	public boolean persist(Save save) {
		this.createSaveFolder();
		File saveFile = new File(String.format("%s/%s.%s", SAVE_FOLDER, save.getName(), "save"));
		try (FileOutputStream f = new FileOutputStream(saveFile); ObjectOutputStream o = new ObjectOutputStream(f);) {
			o.writeObject(save);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void createSaveFolder() {
		File file = new File(SAVE_FOLDER);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	private Save findByName(String name) {

		this.createSaveFolder();
		File saveFile = new File(name);
		try (FileInputStream fi = new FileInputStream(saveFile); ObjectInputStream oi = new ObjectInputStream(fi);) {
			return (Save) oi.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Save> list() {
		this.createSaveFolder();
		ArrayList<Save> arrayList = new ArrayList<>();
		try (Stream<Path> paths = Files.walk(Paths.get(new File(SAVE_FOLDER).getAbsolutePath()))) {
			paths.filter(Files::isRegularFile)
			.filter(p -> p.toString().endsWith(SAVE_EXTENSION))
			.forEach(p -> {
				arrayList.add(this.findByName(p.toString()));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public static SaveRepositoryImpl getSaveRespository() {
		return instance;
	}

}
