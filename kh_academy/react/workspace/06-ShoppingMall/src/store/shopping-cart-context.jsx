import { createContext, useReducer } from "react";
import { DUMMY_PRODUCTS } from "../dummy-products";

export const CartContext = createContext({
  items: [],
  addItemToCart: () => {},
  updateCartItemQuantity: () => {},
}); // 리턴하는 데이터가 컴포넌트

function shoppingCartReducer(state, action) {
  if(action.type === 'ADD_ITEM') {
    // 장바구니에 아이템을 추가 -> shoppingCartState에 있는 item을 하나 더해주는거
    const updatedItems = [...state.items];

      const existingCartItemIndex = updatedItems.findIndex(
        (cartItem) => cartItem.id === action.payload
      );
      const existingCartItem = updatedItems[existingCartItemIndex];

      if (existingCartItem) {
        const updatedItem = {
          ...existingCartItem,
          quantity: existingCartItem.quantity + 1,
        };
        updatedItems[existingCartItemIndex] = updatedItem;
      } else {
        const product = DUMMY_PRODUCTS.find((product) => product.id === action.payload);
        updatedItems.push({
          id: action.payload,
          name: product.title,
          price: product.price,
          quantity: 1,
        });
      }

      return {
        ...state, // 지금 당장은 필요 없지만(items 변수 하나만 관리하니까), 습관적으로 이용
        items: updatedItems,
      };
  }
  if(action.type === 'UPDATE_ITEM') {
    const updatedItems = [...state.items];
      const updatedItemIndex = updatedItems.findIndex(
        (item) => item.id === action.payload.productId
      );

      const updatedItem = {
        ...updatedItems[updatedItemIndex],
      };

      updatedItem.quantity += action.payload.amount;

      if (updatedItem.quantity <= 0) {
        updatedItems.splice(updatedItemIndex, 1);
      } else {
        updatedItems[updatedItemIndex] = updatedItem;
      }

      return {
        ...state,
        items: updatedItems,
      };
  }
  return state;
}

export default function CartContextProvider({ children }) {
  const [shoppingCartState, shoppingCartDispatch] = useReducer(
    shoppingCartReducer,
    {
      items: [],
    }
  ); // 1번째 요소 : useReducer가 관리하는 변수, 2번째 요소 : dispatcher, 함수를 실행해주는 주체

  function handleAddItemToCart(id) {
    // Reduce함수를 실행할 때 전달되는 파라미터로 action에 해당하는 부분, 숫자 및 텍스트 가능.
    shoppingCartDispatch({
      type:'ADD_ITEM',
      payload: id
    });
  }

  function handleUpdateCartItemQuantity(productId, amount) {
    shoppingCartDispatch({
      type: 'UPDATE_ITEM',
      payload: { // 객체에서 key와 item 의 이름이 같으면 아래처럼 생략 가능
        productId,
        amount
      }
    })
  }

  const ctxValue = {
    items: shoppingCartState.items,
    addItemToCart: handleAddItemToCart,
    updateCartItemQuantity: handleUpdateCartItemQuantity,
  };

  return (
    <CartContext.Provider value={ctxValue}>{children}</CartContext.Provider>
  );
}
