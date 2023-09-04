public interface Ino {
	No getFilhoDireito();
	No getFilhoEsquerdo();
	No getPai();
	Object getChave();
	void setFilhoDireito(No fD);
	void setFilhoEsquerdo(No fE);
	void setPai(No pai);
	void setChave(Object ch);
}