public class MyList<T> {
    private T[] array;
    private int size;
    private int capacity;
    
    // Varsayılan constructor - başlangıç kapasitesi 10
    @SuppressWarnings("unchecked")
    public MyList() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }
    
    // Kapasite belirterek constructor
    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }
    
    // Dizideki eleman sayısını döndürür
    public int size() {
        return size;
    }
    
    // Dizinin kapasitesini döndürür
    public int getCapacity() {
        return capacity;
    }
    
    // Diziye eleman ekler, gerekirse kapasiteyi 2 katına çıkarır
    public void add(T data) {
        if (size >= capacity) {
            // Kapasiteyi 2 katına çıkar
            capacity *= 2;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[capacity];
            
            // Mevcut elemanları yeni diziye kopyala
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        
        array[size] = data;
        size++;
    }
    
    // Verilen indeksteki değeri döndürür
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }
    
    // Verilen indeksteki veriyi siler ve sonrasındaki verileri sola kaydırır
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        
        T removedElement = array[index];
        
        // Silinen elemandan sonraki elemanları sola kaydır
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        array[size - 1] = null; // Son elemanı null yap
        size--;
        
        return removedElement;
    }
    
    // Verilen indeksteki veriyi yenisi ile değiştirir
    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        }
        
        T oldValue = array[index];
        array[index] = data;
        return oldValue;
    }
    
    // Dizideki elemanları listeleyen toString metodu
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    // Parametrede verilen nesnenin listedeki ilk indeksini verir
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if ((data == null && array[i] == null) || 
                (data != null && data.equals(array[i]))) {
                return i;
            }
        }
        return -1;
    }
    
    // Belirtilen öğenin listedeki son indeksini verir
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if ((data == null && array[i] == null) || 
                (data != null && data.equals(array[i]))) {
                return i;
            }
        }
        return -1;
    }
    
    // Listenin boş olup olmadığını kontrol eder
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Listedeki öğeleri array haline getirir
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }
    
    // Listedeki bütün öğeleri siler
    @SuppressWarnings("unchecked")
    public void clear() {
        this.size = 0;
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
    }
    
    // Parametrede verilen indeks aralığına ait bir liste döner
    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish > size || start >= finish) {
            return new MyList<>();
        }
        
        MyList<T> subList = new MyList<>(finish - start);
        for (int i = start; i < finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }
    
    // Parametrede verilen değerin dizide olup olmadığını kontrol eder
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
} 