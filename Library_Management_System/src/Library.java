public class Library {
    private LibraryItem[] items;
    private Member[] members;
    private int itemIdx;
    private int memberIdx;

    public Library(int maxItems, int maxMembers) {
        items = new LibraryItem[maxItems];
        members = new Member[maxMembers];
        itemIdx = 0;
        memberIdx = 0;
    }

    public boolean addItem(LibraryItem item) {
        if (itemIdx < items.length && findItem(item.getId()) == null) {
            items[itemIdx++] = item;
            return true;
        }
        return false;
    }

    public boolean addMember(Member m) {
        if (memberIdx < members.length && findMember(m.getMemberId()) == null) {
            members[memberIdx++] = m;
            return true;
        }
        return false;
    }

    public LibraryItem findItem(String id) {
        for (int i = 0; i < itemIdx; i++) {
            if (items[i].getId().equalsIgnoreCase(id)) return items[i];
        }
        return null;
    }

    public Member findMember(String id) {
        for (int i = 0; i < memberIdx; i++) {
            if (members[i].getMemberId().equalsIgnoreCase(id)) return members[i];
        }
        return null;
    }

    public boolean processBorrow(String itemId, String memberId) {
        LibraryItem item = findItem(itemId);
        Member m = findMember(memberId);

        if (item != null && m != null && item.getStatus() == ItemStatus.AVAILABLE && m.canBorrow()) {
            if (item.borrowItem(memberId)) {
                m.incBorrowed();
                return true;
            }
        }
        return false;
    }

    public boolean processReturn(String itemId, int daysLate) {
        LibraryItem item = findItem(itemId);
        if (item == null || item.getStatus() != ItemStatus.ON_LOAN) return false;

        Member m = findMember(item.getBorrowerId());
        if (m != null) {
            if (daysLate > 0) {
                m.applyFine(item.getFine(daysLate));
            }
            m.decBorrowed();
        }
        item.returnItem();
        return true;
    }

    public void showAllItems() {
        for (int i = 0; i < itemIdx; i++) items[i].printDetails();
    }

    public void showAllMembers() {
        for (int i = 0; i < memberIdx; i++) members[i].showInfo();
    }
}