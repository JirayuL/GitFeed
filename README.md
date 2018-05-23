# Software Specification and Design pattern work

## Kotlin book store
> base on [http://theory.cpe.ku.ac.th/wiki/index.php/Sw-spec/ebook](http://theory.cpe.ku.ac.th/wiki/index.php/Sw-spec/ebook)

## TODO

### Phase 0
- [x] List available e-books (with mock-up data repository)
    - [x] The app should show the list of all available book titles with prices (from the mock-up data repository) in a list view with no book cover preview.
    - [x] Implementation info:
        - Use repository pattern.
        - Create book repository class that returns mock-up data.
### Phase 1
- [x] List available e-books (real data)
    - [x] The app should make an HTTP request to get the JSON book data (see below)
    - [x] Implementation info:
        - Extract book repository interface from the mock-up one.
        - Create a real repository that actually makes HTTP requests. (Watch old clips on how to do that with AsyncTask)
### Phase 2
- [x] Basic search functionality
    - [x] The user should be able to search for books by parts of the titles and publication years
    - [x] The user should be able to sort the search result by titles and publication years
        - Implementation info:
        - The search functionality should be implemented in the repository class. It might be good to put the code in some concrete parent class that both the real and the mock-up repository classes extend.
### Phase 3
- [ ] Basic account operations: check fund & add fund (all mock-up)
- [ ] Buy an e-book
    - [ ] A user can add e-book to the cart
    - [ ] A user can check-out all e-books in the cart. Don't forget to check if the user has enough fund in the account.
- [ ] Show list of user's e-books
### Phase 4
- [ ] Basic book promotions
    - [ ] Load promotion data and show promotions (see below)
    - [ ] The app should only show available promotions (ones where the user can only buy--i.e., if a promotion contains books A, B, and C, but the user has already bought book B, the promotion is not available to the user).
    - [ ] Buy e-books from the promotion.
### Phase 5
- [ ] Show book information after clicking the book on the list with book cover
- [ ] Show book cover (in all book list, and user's collection)
    - [ ] The image URLs are in the img_url fields
### Phase 6
- [ ] Refund (within 5 minutes)
