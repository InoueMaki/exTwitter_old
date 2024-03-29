package exTwitter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static void main(String[] args){

		//ハッシュ値を計算したい文字列
		String text1 = "password1";
		String text2 = "password1";

		String hash1 = hash(text1);
		String hash2 = hash(text2);

		System.out.println(hash1);
		System.out.println(hash2);

		if(hash1.equals(hash2)){
			System.out.println("ハッシュ値が等しい");
		}else{
			System.out.println("ハッシュ値が違う");
		}

	}
	
	//Stringのハッシュ値を計算するメソッド
	public static String hash(String text){

		// 変数初期化
		MessageDigest md = null;
		StringBuffer buffer = new StringBuffer();

		try {
			// メッセージダイジェストインスタンス取得
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// 例外なし
			//(getInstanceメソッドの引数"SHA-256"はいじらないこと)
		}

		// ハッシュ値を格納
		md.update(text.getBytes());
		byte[] valueArray = md.digest();

		// ハッシュ値の配列をループ
		for(int i = 0; i < valueArray.length; i++){
			//16進数に変換(「&0xff」をつけないとなぜか変になる)
			String tmpStr = Integer.toHexString(valueArray[i]&0xff);

			if(tmpStr.length() == 1){
				// 値が一桁だった場合、先頭に0を追加し、バッファに追加
				buffer.append('0').append(tmpStr);
			} else {
				// その他の場合、バッファに追加
				buffer.append(tmpStr);
			}
		}
		//ハッシュ値リターン
		return buffer.toString();
	}
}
