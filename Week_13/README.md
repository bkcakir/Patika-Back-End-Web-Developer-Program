# Kütüphane Yönetim Sistemi

Bu proje, Spring Boot kullanılarak geliştirilmiş bir kütüphane yönetim sistemidir. CRUD operasyonları yapabilen REST API'ler içerir.

## Teknolojiler

- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Spring Validation**

## Proje Yapısı

```
src/main/java/com/library/management/
├── entity/          # JPA Entity sınıfları
├── repository/      # JPA Repository sınıfları
├── service/         # İş mantığı katmanı
├── controller/      # REST Controller sınıfları
├── dto/            # Data Transfer Object sınıfları
├── exception/      # Exception handling
└── config/         # Konfigürasyon sınıfları
```

## Veritabanı Yapısı

### Entity İlişkileri

- **Book - Author**: One-to-Many (Bir kitabın bir yazarı, bir yazarın birden fazla kitabı)
- **Book - Category**: Many-to-Many (Bir kitap birden fazla kategoriye ait olabilir)
- **Book - Publisher**: One-to-Many (Bir kitabın bir yayınevi, bir yayınevinin birden fazla kitabı)
- **Book - BookBorrowing**: One-to-Many (Bir kitap birden fazla ödünç alma işlemine sahip olabilir)

## Kurulum

1. PostgreSQL veritabanını kurun ve `library_management` adında bir veritabanı oluşturun
2. `application.properties` dosyasındaki veritabanı bağlantı bilgilerini güncelleyin
3. Projeyi çalıştırın: `mvn spring-boot:run`

## API Endpoint'leri

### Yazar (Author) Endpoint'leri

| HTTP Metodu | Endpoint | Açıklama | Request Body | Response |
|-------------|----------|----------|--------------|----------|
| GET | `/api/authors` | Tüm yazarları listele | - | List<Author> |
| GET | `/api/authors/{id}` | ID'ye göre yazar getir | - | Author |
| POST | `/api/authors` | Yeni yazar oluştur | Author | Author |
| PUT | `/api/authors/{id}` | Yazar güncelle | Author | Author |
| DELETE | `/api/authors/{id}` | Yazar sil | - | 204 No Content |

### Kategori (Category) Endpoint'leri

| HTTP Metodu | Endpoint | Açıklama | Request Body | Response |
|-------------|----------|----------|--------------|----------|
| GET | `/api/categories` | Tüm kategorileri listele | - | List<Category> |
| GET | `/api/categories/{id}` | ID'ye göre kategori getir | - | Category |
| POST | `/api/categories` | Yeni kategori oluştur | Category | Category |
| PUT | `/api/categories/{id}` | Kategori güncelle | Category | Category |
| DELETE | `/api/categories/{id}` | Kategori sil (kitap kontrolü ile) | - | String |

### Yayınevi (Publisher) Endpoint'leri

| HTTP Metodu | Endpoint | Açıklama | Request Body | Response |
|-------------|----------|----------|--------------|----------|
| GET | `/api/publishers` | Tüm yayınevlerini listele | - | List<PublisherResponseDto> |
| GET | `/api/publishers/{id}` | ID'ye göre yayınevi getir | - | PublisherResponseDto |
| POST | `/api/publishers` | Yeni yayınevi oluştur | PublisherRequestDto | PublisherResponseDto |
| PUT | `/api/publishers/{id}` | Yayınevi güncelle | PublisherRequestDto | PublisherResponseDto |
| DELETE | `/api/publishers/{id}` | Yayınevi sil | - | 204 No Content |

### Kitap (Book) Endpoint'leri

| HTTP Metodu | Endpoint | Açıklama | Request Body | Response |
|-------------|----------|----------|--------------|----------|
| GET | `/api/books` | Tüm kitapları listele | - | List<Book> |
| GET | `/api/books/{id}` | ID'ye göre kitap getir | - | Book |
| POST | `/api/books` | Yeni kitap oluştur | Book | Book |
| PUT | `/api/books/{id}` | Kitap güncelle | Book | Book |
| DELETE | `/api/books/{id}` | Kitap sil | - | 204 No Content |

### Kitap Ödünç Alma (BookBorrowing) Endpoint'leri

| HTTP Metodu | Endpoint | Açıklama | Request Body | Response |
|-------------|----------|----------|--------------|----------|
| GET | `/api/book-borrowings` | Tüm ödünç alma işlemlerini listele | - | List<BookBorrowing> |
| GET | `/api/book-borrowings/{id}` | ID'ye göre ödünç alma işlemi getir | - | BookBorrowing |
| POST | `/api/book-borrowings` | Yeni ödünç alma işlemi oluştur (stok kontrolü ile) | BookBorrowing | BookBorrowing |
| PUT | `/api/book-borrowings/{id}` | Ödünç alma işlemi güncelle (email olmadan) | BookBorrowingUpdateDto | BookBorrowing |
| PUT | `/api/book-borrowings/{id}/return` | Kitap iade et | - | BookBorrowing |
| DELETE | `/api/book-borrowings/{id}` | Ödünç alma işlemi sil | - | 204 No Content |

## Özellikler

### İş Mantığı Kontrolleri

1. **Kategori Silme Kontrolü**: Kategoriye ait kitap varsa silme işlemi gerçekleşmez
2. **Stok Kontrolü**: Kitap ödünç alınırken stok kontrolü yapılır
3. **Otomatik Stok Yönetimi**: Kitap ödünç alındığında stok azalır, iade edildiğinde artar

### DTO Kullanımı

- **Publisher**: GET isteklerinde adres bilgisi döndürülmez
- **BookBorrowing**: Güncelleme işlemlerinde email alanı kullanılmaz

### Validation

- Tüm DTO'larda gerekli validation anotasyonları kullanılmıştır
- Global exception handler ile hata yönetimi yapılmıştır

## Örnek Kullanım

### Yeni Kitap Oluşturma

```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Java Programming",
    "publicationYear": 2023,
    "stock": 5,
    "author": {"id": 1},
    "publisher": {"id": 1},
    "categories": [{"id": 1}]
  }'
```

### Kitap Ödünç Alma

```bash
curl -X POST http://localhost:8080/api/book-borrowings \
  -H "Content-Type: application/json" \
  -d '{
    "borrowerName": "Ahmet Yılmaz",
    "borrowerEmail": "ahmet@example.com",
    "book": {"id": 1}
  }'
```

### Kitap İade Etme

```bash
curl -X PUT http://localhost:8080/api/book-borrowings/1/return
```

## HTTP Status Kodları

- **200 OK**: Başarılı işlem
- **201 Created**: Yeni kayıt oluşturuldu
- **204 No Content**: Başarılı silme işlemi
- **400 Bad Request**: Geçersiz istek
- **404 Not Found**: Kayıt bulunamadı
- **500 Internal Server Error**: Sunucu hatası 