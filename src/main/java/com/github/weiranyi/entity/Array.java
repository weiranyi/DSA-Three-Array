package com.github.weiranyi.entity;

/**
 * @author: https://github.com/weiranyi
 * @description 自定义数组类
 * @date: 2021/4/10 3:43 下午
 * @Version 1.0
 */
public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认容量为this()中的数值
     */
    public Array() {
        this(10); //开辟默认空间
    }

    /**
     * @return 数组元素个数，数组长度
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 数组开辟的内存空间
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在数组的第一个位置添加一个新的新元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在数组的index的位置插入新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("添加元素失败，数组已经满了！");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加元素失败，插入非法，请在index介于0到size之间位置进行插入！！！");
        }
        for (int i = size - 1; i >= index; i--) {
            // 每个元素向后挪一个位置
            data[i + 1] = data[i];
        }
        // 覆盖
        data[index] = e;
        size++;
    }

    /**
     * 从数组中删除index位置的元素
     *
     * @param index
     * @return 返回删除的元素
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 从数组中删除第一个元素
     *
     * @return 返回删除的元素
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     *
     * @return 返回删除的元素
     */
    public int removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 修改index位置的元素
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，index索引非法,index在0～" + size + "之间");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e
     * @return 有就返回true，没有就 false
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param e
     * @return 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index
     * @return 获取index对应元素
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，index索引非法,index在0～" + size + "之间");
        }
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            // 是否是最后一个元素
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}