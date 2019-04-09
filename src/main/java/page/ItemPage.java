package page;

import controller.rest.ItemController;
import table.Cell;
import table.Filter;
import table.Page;
import table.Row;
import xtuple.XItem;

public class ItemPage extends VuePage{
	public ItemPage() {
		
		addFilter(new Filter("Item Number"));
		addColumn(new Cell(Cell.CENTER_ALIGN,"Item #"));
		addColumn(new Cell(Cell.CENTER_ALIGN,"Description"));
		addColumn(new Cell(Cell.CENTER_ALIGN,"Price"));
		addColumn(new Cell(Cell.CENTER_ALIGN,"QOH"));
		
		Page p = new Page();
		
		XItem[] items = ItemController.getItems(p);
		
		for(XItem item : items)
		{
			Row r = new Row();
			r.addCell(new Cell(Cell.LEFT_ALIGN,item.getNumber()));
			r.addCell(new Cell(Cell.LEFT_ALIGN,item.getDescrip1()));
			r.addCell(new Cell(Cell.RIGHT_ALIGN,""+item.getListprice()));
			r.addCell(new Cell(Cell.RIGHT_ALIGN,""+item.getInv_uom_id()));
		}
		
		setNextPage("/item/get-items?offset="+p.getOffset()+"&size="+p.getSize());
		
	}
}
