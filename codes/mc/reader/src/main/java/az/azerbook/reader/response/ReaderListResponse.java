package az.azerbook.reader.response;

import java.util.List;

import az.azerbook.reader.entity.ReaderEntity;
import lombok.Data;

@Data
public class ReaderListResponse {

	private List<ReaderEntity> readerResponse;

	private List<ReaderResponse> readerwitdhBooks;
}