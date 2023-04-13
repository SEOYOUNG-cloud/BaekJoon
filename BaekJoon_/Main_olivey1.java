package test;

import java.util.*;
import java.io.*;

public class oliveyoung3 {

	static class File {
		String name, size;

		public File(String name, String size) {
			super();
			this.name = name;
			this.size = size;
		}
	}

	static Map<String, ArrayList<File>> file;
	static Map<String, ArrayList<String>> folder;
	static Set<String> except;
	static ArrayList<String> size;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		String[][] folders = { { "animal", "root" }, { "fruit", "root" }};
		String[][] files = { { "cat", "1B", "animal" }, { "dog", "2B", "animal" }, { "apple", "4B", "fruit" }};
		String[] selected = {"animal"};
		String[] excepted = { "apple" };

		except = new HashSet<>(Arrays.asList(excepted)); // set에 넣음

		folder = new HashMap<>(); // 부모-자식들 이렇게 저장한다
		for (int i = 0; i < folders.length; i++) {
			String down = folders[i][0]; // 자식
			String up = folders[i][1]; // 부모

			folder.put(down, new ArrayList<>());
			ArrayList<String> sons;
			if (folder.containsKey(up)) { // 부모가 있다면
				sons = folder.get(up); // 자식들
			} else {
				sons = new ArrayList<>();
			}

			sons.add(down); // 자식 추가
			folder.put(up, sons); // 넣기
		}
		
		file = new HashMap<>(); // 폴더명 - 파일들 이렇게 저장
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i][0];
			String fileSize = files[i][1];
			String folderName = files[i][2];
			
			ArrayList<File> fileInfo;
			if (file.containsKey(folderName)) {
				fileInfo = file.get(folderName);
			} else {
				fileInfo = new ArrayList<>();
			}
			fileInfo.add(new File(fileName, fileSize));
			file.put(folderName, fileInfo);
		}

		///
		size = new ArrayList<>();

		for (int i = 0; i < selected.length; i++) {
			String selectFolder = selected[i];
			checkFolderList = new ArrayList<>();
			
			if(folder.containsKey(selectFolder)) {
				deep(selectFolder);
			}
			
			System.out.println(checkFolderList);
			
			for(String checkFolder : checkFolderList) {
				me(checkFolder);
			}
		}
		
		int answer[] = new int[2];
		answer[1] = cnt;
		for(String unit : size) {
			if(unit.charAt(unit.length() -2) == 'K') {
				answer[0] += Integer.parseInt(unit.substring(0, unit.length()-2)) * 1024;
			} else {
				answer[0] += Integer.parseInt(unit.substring(0, unit.length()-1));
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}

	private static void me(String select) { // 폴더 속 파일 훑기, select: 선택된 폴더
		if(file.containsKey(select)) {
			ArrayList<File> fileList = file.get(select);
			for (int f = 0; f < fileList.size(); f++) {
				// 파일들을 훑으면서
				File outFile = fileList.get(f);
				if (!except.contains(outFile.name)) { // 제외 목록에 없으면
					cnt += 1;
					size.add(outFile.size);
				}
			}
		}
		// 파일 삭제
		folder.remove(select);
	}
	static ArrayList<String> checkFolderList;
	private static void deep(String selectFolder) {
		checkFolderList.add(selectFolder); // 훑을 리스트에 넣는다.

		if(folder.containsKey(selectFolder)) { // folder 목록에 존재한다면
			ArrayList<String> underFolderList = folder.get(selectFolder);
			
			for(String underFile : underFolderList) {
				deep(underFile);
			}
		}
	}

}
