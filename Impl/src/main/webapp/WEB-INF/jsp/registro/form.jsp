<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<label>Data</label>
<input type="text" name="data" value="<fmt:formatDate value="${registro.dataHora}" pattern="dd/MM/yyyy" />" class="input-xxlarge dataMask" placeholder="Data" />
<label>Hora</label>
<input type="text" name="hora" value="<fmt:formatDate value="${registro.dataHora}" pattern="HH:mm:ss" />" class="input-xxlarge horaMask" placeholder="Hora"/>
<hr/>
<input type="submit" class="btn btn-primary" value="Salvar" />