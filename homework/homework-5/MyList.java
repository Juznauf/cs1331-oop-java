public class MyList<E> implements List<E> {

    private E[] elements;/* this is the backing array */
    private int size = 0; /* an int that represents the count of all 
    non-null elements in the array */

    public MyList() {
        this.elements = (E[]) new Object[List.INITIAL_CAPACITY];
    }

    public MyList(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }

    public void add(E e) {

        if (size() == List.INITIAL_CAPACITY) {
            // double the size 
            int cap = size() * 2;
            MyList<E> copyElements = new MyList(cap);
            // copy the initial list
            for (int i=0; i<size(); ++i) {
                copyElements.elements[i] = elements[i];
            }
            // add the last element
            copyElements.elements[size()] = e;
            // replace the original list
            this.elements = copyElements.elements;
        } else {
            // just add to the end of the list
            this.elements[size()] = e;
        }
    }

    public E get(int index) {
        if (index > size()-1) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.elements[index];
        }
    }

    public void replace(E e, E replaceWith) {
        if (e == null || replaceWith == null) {
            throw new IllegalArgumentException();
        } else {
            for (int i=0; i < elements.length; ++i) {
                if (elements[i] == e) {
                    elements[i] = replaceWith;
                }
            }
        }
    }

    public int remove(E e) {
        int count=0;

        if (e == null) {
            throw new IllegalArgumentException();
        } else {
            MyList<E> copyElements = new MyList(size());
            for (int i=0; i < size(); ++i) {
                if (elements[i] == e){
                    count ++;
                    // just pass
                } else {
                    copyElements.add(elements[i]);
                }
            }
            this.elements = copyElements.elements;
        }
        return count;
    }

    public int contains(E e) {
        int count=0;
        for (E element: elements) {
            if (element == e) {
                count ++;
            }
        }

        return count;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        // elements = new MyList().elements;
        elements = (E[]) new Object[List.INITIAL_CAPACITY];
    }

    public int size() {

        int count = 0;
        for (E element: elements) {
            if (!(element == null)) {
                count++;
            }
        }
        size = count;
        return count;
    }

    public E[] toArray(E[] e) {
        // not properly init as unclear requirements
        System.out.print('{');
        int count = e.length;
        MyList<E> copyElements = new MyList();
        for (E element: elements) {
            if (count == 0) {
                break;
            } else if (count == 1){
                copyElements.add(element);
                System.out.print(element);
            } else {
                copyElements.add(element);
                System.out.print(element+",");
            }
        }
        System.out.print("}%n");
        return copyElements.elements;
    }


    public static void main(String[] args) {
        
    }
}