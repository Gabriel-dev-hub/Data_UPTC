//@autors: Gabriel Cely 202213440, William Gonzalez 202213375


class Node {

    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {

    constructor() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    push(data) {
        const node = new Node(data);
        if (this.first === null) {
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            this.last = node;
        }
        this.size++;
    }

    pull() {
        if (this.first === null) {
            return null;
        }
        const data = this.first.data;
        this.first = this.first.next;
        this.size--;
        return data;
    }

    peek() {
        if (this.first === null) {
            return null;
        }
        return this.first.data;
    }

    isEmpty() {
        return this.first === null;
    }
}

const queue = new Queue();
queue.push(1);
queue.push(2);
queue.push(3);
queue.push(4);
queue.push(5);
queue.push(6);
console.log(queue.pull());
console.log(queue.peek());
console.log(queue.size);
console.log(queue.isEmpty());
console.log(queue.pull());
console.log(queue.pull());
console.log(queue.pull());
console.log(queue.pull());
console.log(queue.pull());
console.log(queue.isEmpty());