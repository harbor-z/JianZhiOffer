public class Test{

	public static class LinkedList{
		int data;
		LinkedList next;

		public LinkedList(int data){
		  this.data = data;
		  this.next = null;
		}
	}

	public static LinkedList isCyclicLinkedList(LinkedList head){
		if(head == null){
			return null;
		}

		LinkedList pOne = head; // one step per move
		LinkedList pTwo = head; // two step per move

		if(pTwo.next != null){
			pTwo = pTwo.next.next;
		} else {
			return null;
		}
		pOne = pOne.next;

		// find the first meet, or null
		while(pTwo != pOne){
			if(pTwo != null && pTwo.next != null){
				pTwo = pTwo.next.next;
			} else{
				return null;
			}

			pOne = pOne.next;
		}

		// cyclic, find the first node in the cycle
		while(head != pOne){
			pOne = pOne.next;
			head = head.next;
		}

		return pOne;
	}
}
