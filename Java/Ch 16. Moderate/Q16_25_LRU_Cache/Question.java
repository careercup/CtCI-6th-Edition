package Q16_25_LRU_Cache;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cache_size = 5;
		Cache cache = new Cache(cache_size);
		
		cache.setKeyValue(1, "1");
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(2, "2");
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(3, "3");
		System.out.println(cache.getCacheAsString());
		cache.getValue(1);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(4, "4");
		System.out.println(cache.getCacheAsString());
		cache.getValue(2);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(5, "5");
		System.out.println(cache.getCacheAsString());
		cache.getValue(5);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(6,  "6");
		System.out.println(cache.getCacheAsString());
		cache.getValue(1);
		System.out.println(cache.getCacheAsString());
		cache.setKeyValue(5, "5a");
		System.out.println(cache.getCacheAsString());
		cache.getValue(3);
		System.out.println(cache.getCacheAsString());
		// 6->5->2->4->1
	}

}
